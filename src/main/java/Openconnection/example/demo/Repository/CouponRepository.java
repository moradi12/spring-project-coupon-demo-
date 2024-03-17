package Openconnection.example.demo.Repository;

import Openconnection.example.demo.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByCompanyId(Integer companyId);
    Coupon findByTitle(String title);
    boolean existsByTitleAndCompanyId(String title, int companyId);

    void deleteByEndDateBefore(Date endDate);
}
