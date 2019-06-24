package org.bajiepka.websocket.application.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractChatMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @CreationTimestamp
    @Column(name = "created_at")
    protected Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    protected Date updatedAt;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    protected Boolean isDeleted;

    @Column(name = "deleted_at")
    protected Date deletedAt;

}
