package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {

        val list = mutableListOf(
            Person(
                id = counter.incrementAndGet(),
                firstName = "Eduardo",
                lastName = "Lima",
                address = "Rua L, 2037, Viva Cidade",
                gender = "masculino"
            ),
            Person(
                id = counter.incrementAndGet(),
                firstName = "Fernanda",
                lastName = "Santos",
                address = "Rua L, 2037, Viva Cidade",
                gender = "masculino"
            )
        )

        logger.info("find all person $list")

        return list
    }

    fun findById(id: Long): Person {
        val person = Person(
            id = counter.incrementAndGet(),
            firstName = "Eduardo",
            lastName = "Lima",
            address = "Rua L, 2037, Viva Cidade",
            gender = "masculino"
        )

        logger.info("find one person $person")

        return person
    }

    fun create(person: Person): Person {
        person.id = counter.incrementAndGet()
        logger.info("create one person $person")
        return person
    }

    fun update(person: Person): Person {
        logger.info("update one person $person")
        return person
    }

    fun delete(id: Long) {
        logger.info("delete one person $id")
    }
}