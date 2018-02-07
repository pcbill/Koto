package tw.pcbill.domain

import org.springframework.data.jpa.repository.JpaRepository

interface DomainDao : JpaRepository<Domain, String>