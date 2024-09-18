package com.inttao.npi.backend.util.domain;


import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Objects;


public abstract class AbstractEntity<T> implements Persistable, Serializable, HasId<T> {


    private int version;

    @Transient
    private boolean newEntity;

    @Override
    public abstract T getId();

    public abstract void setId(T id);

    public void setVersion(int version) {
        this.version = version;
    }
    public int getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;
        return version == that.version &&
                Objects.equals(getId(), that.getId());
    }

    public void setNew(boolean newInstance) {
        this.newEntity = newInstance;
    }

    @Override
    public boolean isNew() {
        return newEntity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion());
    }
}
