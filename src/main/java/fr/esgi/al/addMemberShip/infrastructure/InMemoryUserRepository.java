package fr.esgi.al.addMemberShip.infrastructure;

import fr.esgi.al.addMemberShip.domain.Membership;
import fr.esgi.al.addMemberShip.domain.UserId;
import fr.esgi.al.addMemberShip.domain.UserRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<UserId, Membership> data = new ConcurrentHashMap<>();

    @Override
    public void save(Membership membership) {
        data.put(membership.getId(), membership);
    }


    @Override
    public Membership byId(UserId userId) {
        final Membership membership = data.get(userId);
        if (membership == null) {
            throw new RuntimeException("No user for " + userId.getValue());
        }
        return membership;
    }

    @Override
    public UserId nextId() {
        return UserId.of(String.valueOf(counter.incrementAndGet()));
    }
}
