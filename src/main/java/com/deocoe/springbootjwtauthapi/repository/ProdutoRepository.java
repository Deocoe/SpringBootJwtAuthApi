package com.deocoe.springbootjwtauthapi.repository;

import com.deocoe.springbootjwtauthapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
