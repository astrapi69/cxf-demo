package de.alpharogroup.boot.cxf.demo.entity


import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
class Bro(@Id @GeneratedValue(strategy = IDENTITY)@JsonIgnore var id: Long = -1,
          @Column(name = "first_name") var firstName: String = "", @Column(name = "last_name") var lastName: String = "") {

}
