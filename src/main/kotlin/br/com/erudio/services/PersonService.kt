package br.com.erudio.services

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.data.vo.v2.PersonVO as PersonVOV2
import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.mapper.custom.PersonMapper
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("find all person")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("find one person")
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(personVO: PersonVO): PersonVO {
        logger.info("create one person")

        val entity = DozerMapper.parseObject(personVO, Person::class.java)

        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun createV2(personVO: PersonVOV2): PersonVOV2 {
        logger.info("create one person")

        val entity = mapper.mapVoToEntity(personVO)

        return mapper.mapEntityToVo(repository.save(entity))
    }

    fun update(personVO: PersonVO): PersonVO {
        val entity = repository.findById(personVO.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = personVO.firstName
        entity.lastName = personVO.lastName
        entity.address = personVO.address
        entity.gender = personVO.gender

        logger.info("update one person")

        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)

    }

    fun delete(id: Long) {
        logger.info("delete one person")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}