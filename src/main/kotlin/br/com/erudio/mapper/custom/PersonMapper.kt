package br.com.erudio.mapper.custom

import br.com.erudio.data.vo.v2.PersonVO
import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {
    fun mapEntityToVo(person: Person): PersonVO{
        val vo = PersonVO()

        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.address = person.address
        vo.gender = person.gender
        vo.birthDay = Date()

        return vo
    }

    fun mapVoToEntity(personVO: PersonVO): Person{
        val entity = Person()

        entity.id = personVO.id
        entity.firstName = personVO.firstName
        entity.lastName = personVO.lastName
        entity.address = personVO.address
        entity.gender = personVO.gender
        //entity.birthDay = personVO.birthDay

        return entity
    }
}