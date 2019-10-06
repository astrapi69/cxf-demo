package de.alpharogroup.boot.cxf.demo.service

import de.alpharogroup.boot.cxf.demo.entity.Bro
import de.alpharogroup.boot.cxf.demo.entity.BroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class BroService @Autowired constructor(val broRepository: BroRepository) {

    fun save(bro: Bro): Optional<Bro> {
        return Optional.of(broRepository.save(bro))
    }

    fun findById(id: Long): Optional<Bro> {
        return broRepository.findById(id)
    }

    fun findAll(): List<Bro>{
        return broRepository.findAll()
    }

    fun update(id: Long, bro: Bro): Optional<Bro> {
        if(findById(id).isPresent){
            return save(bro)
        } else
            throw NoSuchElementException()
    }

    fun deleteById(id: Long) {
        broRepository.deleteById(id)
    }
}