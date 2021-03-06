package portaltek.cleancode.infra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public abstract class AbstractRepoInMemory<T, ID> {
    private ConcurrentHashMap<ID, T> map = new ConcurrentHashMap<>();

    abstract protected ID getId(T entity);

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(map.get(id));
    }

    public Page<T> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

    public T save(T entity) {
        requireNonNull(entity);
        map.put(getId(entity), entity);
        return entity;
    }


}
