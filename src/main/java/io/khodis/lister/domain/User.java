package io.khodis.lister.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(
        indexes = @Index(columnList = "telegramId"),
        uniqueConstraints = @UniqueConstraint(columnNames = "telegramId")
)
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    private int telegramId;

    @CreationTimestamp
    @NotNull
    private Date creationTime;

    public User(int telegramId) {
        this.telegramId = telegramId;
    }

    // private ItemList itemList;
}
