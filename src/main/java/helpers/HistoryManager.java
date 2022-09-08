package helpers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class HistoryManager {

  private ShopingDao shopingDao;
  private ProductDao productDao;

  public HistoryManager(ShopingDao shopingDao, ProductDao productDao) {
    this.shopingDao = shopingDao;
    this.productDao = productDao;
  }

  public void showPurchaseHistory(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {

    List<Bying> purchases = shopingDao.getAllPurchase();
    request.setAttribute("listPurchase", purchases);
    RequestDispatcher dispatcher = request.getRequestDispatcher("purchase-list.jsp");
    dispatcher.forward(request, response);
  }

  public void saveSelectedCountToSession(HttpServletRequest request) {
    Integer providedCount = Integer.parseInt(request.getParameter("count"));
    request.getSession().setAttribute("productsCount", providedCount);
  }

  public void addToBasket(HttpServletRequest request) {
    HttpSession session = request.getSession();
    Integer productsCount = Integer.parseInt(request.getParameter("count"));
    Integer preselectedProductId = (Integer) session.getAttribute("selectedProductId");
    if (preselectedProductId != null) {
      Product existingProduct = productDao.getProduct(preselectedProductId);
      Card basketItem = new Card(existingProduct, productsCount);

      List<Card> currentBaksetItems = (List<Card>) session.getAttribute("basketItems");
      if (currentBaksetItems == null) {
        currentBaksetItems = new ArrayList<>();
      }
      currentBaksetItems.add(basketItem);
      session.setAttribute("basketItems", currentBaksetItems);
    }
  }

  public void showBasketPage(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("products-card.jsp");
    dispatcher.forward(request, response);
  }

  public void showNewForm(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
    dispatcher.forward(request, response);
  }

  public void showEditForm(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    Product existingProduct = productDao.getProduct(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
    request.setAttribute("product", existingProduct);
    dispatcher.forward(request, response);

  }
}