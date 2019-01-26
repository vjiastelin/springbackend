package com.example.entities

import org.springframework.data.util.ProxyUtils
import java.io.Serializable
import javax.persistence.*


@MappedSuperclass
abstract class AbstractEntity<T:Serializable> {
    companion object {
        private val serialVersionUID = -5554308939380869754L
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial_seq")
    @SequenceGenerator(
            name="serial_seq",
            sequenceName="serial",
            allocationSize = 1
    )
    private var id:T? = null

    fun getId() : T? {
        return id
    }

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as AbstractEntity<*>

        return if (null == this.getId()) false else this.getId() == other.getId()
    }

    override fun hashCode(): Int {
        return 31
    }

    override fun toString() = "Entity of type ${this.javaClass.name} with id: $id"
}