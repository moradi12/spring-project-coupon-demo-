package Openconnection.example.demo.clr;
import Openconnection.example.demo.database.Repository.CouponRepository;
import Openconnection.example.demo.database.beans.Coupon;
import Openconnection.example.demo.database.beans.Category;
import Openconnection.example.demo.Exceptions.ErrMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UpdateCrudCoupon implements CommandLineRunner {
    @Autowired
    CouponRepository couponRepository;

    //change to your correct id ..
    @Override
    public void run(String... args) {
        updateCoupon(1, "NewWorld", "NewToys", Category.Food, 3, 50.99, "imgur");

    }

    /**
     * Updates a coupon with the specified ID
     * @param id The ID of the coupon to update
     * @param title The new title of the coupon
     * @param description The new description of the coupon
     * @param category The new category of the coupon
     * @param amount The new amount of the coupon
     * @param price The new price of the coupon
     * @param image The new image URL of the coupon
     */

    private void updateCoupon(Integer id, String title, String description, Category category, int amount, double price, String image) {
        try {
            Coupon existingCoupon = couponRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException(ErrMsg.COUPON_NOT_FOUND.getMsg()));

            existingCoupon.setTitle(title);
            existingCoupon.setDescription(description);
            existingCoupon.setCategory(category);
            existingCoupon.setAmount(amount);
            existingCoupon.setPrice(price);
            existingCoupon.setImage(image);

            // Save the updated coupon
            couponRepository.saveAndFlush(existingCoupon);
            System.out.println("Coupon with ID " + id + " updated successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred during coupon update for ID " + id + ": " + e.getMessage());
        }
    }
}
