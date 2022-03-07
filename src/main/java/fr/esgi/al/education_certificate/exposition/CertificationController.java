package fr.esgi.al.education_certificate.exposition;

import fr.esgi.al.education_certificate.application.CreateCertification;
import fr.esgi.al.education_certificate.domain.EducationCertificationId;
import fr.esgi.al.kernel.CommandBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CertificationController {

    private final CommandBus commandBus;


    public CertificationController(CommandBus commandBus ) {
        this.commandBus = commandBus;
    }

    @PostMapping(path = "/education-Certification/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid CertificationRequest request) {
        CreateCertification createCertification = new CreateCertification(request.name, new Date(String.valueOf(request.date)), request.ownerId, request.image, request.isValid );
        EducationCertificationId educationCertificationId = commandBus.send(createCertification);
        return ResponseEntity.created(URI.create("/education-Certification/create" + educationCertificationId.getValue())).build();
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
