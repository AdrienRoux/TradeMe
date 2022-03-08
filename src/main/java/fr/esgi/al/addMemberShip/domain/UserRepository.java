package fr.esgi.al.addMemberShip.domain;

import java.util.UUID;

public interface UserRepository {

    void save(Membership membership);

    Membership byId(UserId userId);

    default UserId nextId() {
        return UserId.fromUUID(UUID.randomUUID());
    }

}
