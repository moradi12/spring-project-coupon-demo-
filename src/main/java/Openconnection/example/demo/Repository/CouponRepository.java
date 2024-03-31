package Openconnection.example.demo.Repository;

import Openconnection.example.demo.beans.Category;
import Openconnection.example.demo.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByCompanyId(Integer companyId);

    Coupon findByTitle(String title);

    boolean existsByTitleAndCompanyId(String title, int companyId);

    List<Coupon> findByEndDateBefore(Date endDate);

    List<Coupon> findByCategory(Category category);

    List<Coupon> findByPriceBetween(double minPrice, double maxPrice);


//    @Query("SELECT c FROM Coupon c WHERE c.discountPercentage BETWEEN :minDiscount AND :maxDiscount AND c.available = :available")
//    List<Coupon> findByDiscountPercentageBetweenAndAvailable(double minDiscount, double maxDiscount, boolean available);
}
