package fr.esgi.al.addMemberShip.exposition;

import fr.esgi.al.kernel.CommandBus;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.esgi.al.addMemberShip.application.CreateTradesman;
import fr.esgi.al.addMemberShip.domain.Location;
import fr.esgi.al.addMemberShip.domain.UserId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


    @RestController
    public class UserController {

        private final CommandBus commandBus;


        public UserController(CommandBus commandBus ) {
            this.commandBus = commandBus;
        }

        @PostMapping(path = "/tradesman/create", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> create(@RequestBody @Valid TradesmanRequest request) {
            CreateTradesman createUser = new CreateTradesman(request.lastname, request.firstname, new Date(String.valueOf(request.birthdate)),false,  new Location(request.location.address, request.location.city)  );
            UserId userId = commandBus.send(createUser);
            return ResponseEntity.created(URI.create("/tradesman/create" + userId.getValue())).build();
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, String> handleValidationExceptions(
                MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return errors;
        }
    }

