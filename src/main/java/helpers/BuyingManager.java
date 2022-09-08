package helpers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.ProductDao;
import dao.ShopingDao;
import entities.Card;
import entities.Product;
import entities.Bying;
import entities.BuyProduct;

public class BuyingManager {

  private ShopingDao shopingDao;
  private ProductDao productDao;

  public BuyingManager(ShopingDao shopingDao, ProductDao productDao) {
    this.shopingDao = shopingDao;
    this.productDao = productDao;
  }

  public void saveSelectedProduct(HttpServletRequest request) {
    HttpSession session = request.getSession();
    Integer productId = Integer.parseInt(request.getParameter("product"));
    session.setAttribute("selectedProductId", productId);
  }

  public void persistPurchase(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    List<Card> currentBaksetItems = (List<Card>) session.getAttribute("basketItems");
    if (currentBaksetItems == null || currentBaksetItems.isEmpty()) {
      return;
    }

    Double totalPrice = currentBaksetItems.stream().map(e -> e.getTotalPrice()).reduce((l, r) -> l + r).get();
    List<BuyProduct> elements = currentBaksetItems.stream()
        .map(e -> new BuyProduct(e.getProduct().getId(), e.getCount()))
        .toList();
    Bying purchase = new Bying(totalPrice, elements);

    shopingDao.savePurchase(purchase);
  }

  public void buyingProducts(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    List<Product> listProducts = productDao.getAllProduct();
    request.setAttribute("listProduct", listProducts);

    HttpSession session = request.getSession();
    Integer preselectedProductId = (Integer) session.getAttribute("selectedProductId");
    if (preselectedProductId != null) {
      Product existingProduct = productDao.getProduct(preselectedProductId);
      request.setAttribute("selectedProduct", existingProduct);
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("product-select.jsp");
    dispatcher.forward(request, response);
  }

}
