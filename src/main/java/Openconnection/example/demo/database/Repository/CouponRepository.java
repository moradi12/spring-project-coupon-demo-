package Openconnection.example.demo.database.Repository;

import Openconnection.example.demo.database.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByCompanyId(Integer companyId);
    Coupon findByTitle(String title);

    void deleteByEndDateBefore(Date endDate);
}
