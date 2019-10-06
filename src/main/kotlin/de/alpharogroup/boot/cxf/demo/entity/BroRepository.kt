package de.alpharogroup.boot.cxf.demo.entity

import org.springframework.data.jpa.repository.JpaRepository

interface BroRepository : JpaRepository<Bro, Long>