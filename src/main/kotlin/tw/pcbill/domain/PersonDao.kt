package tw.pcbill.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PersonDao : JpaRepository<Person, String>