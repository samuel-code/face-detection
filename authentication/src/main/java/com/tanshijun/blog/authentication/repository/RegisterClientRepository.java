package com.tanshijun.blog.authentication.repository;

import com.tanshijun.blog.authentication.model.RegisterClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tanshijun-pc on 2017/10/11.
 */
public interface RegisterClientRepository extends JpaRepository<RegisterClientModel,Long> {
}
