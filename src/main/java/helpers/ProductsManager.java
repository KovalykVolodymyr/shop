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
import entities.Product;

public class ProductsManager {

  private ProductDao productDao;

  public ProductsManager(ProductDao productDao) {
    this.productDao = productDao;
  }

  public void selectProductCount(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    HttpSession session = request.getSession();
    Integer preselectedProductId = (Integer) session.getAttribute("selectedProductId");
    if (preselectedProductId != null) {
      Product existingProduct = productDao.getProduct(preselectedProductId);
      request.setAttribute("selectedProduct", existingProduct);
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("product-count.jsp");
    dispatcher.forward(request, response);

  }

  public void listProducts(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    List<Product> listProducts = productDao.getAllProduct();
    System.out.println(listProducts);
    System.out.println("DIDPRINTPRODUCTS");
    request.setAttribute("listProduct", listProducts);
    RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
    dispatcher.forward(request, response);
  }

  public void updateProduct(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String title = request.getParameter("title");
    Double price = Double.parseDouble(request.getParameter("price"));

    Product product = new Product(id, title, price);
    productDao.updateProduct(product);
    response.sendRedirect("list");
  }

  public void insertProduct(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String title = request.getParameter("title");
    Double price = Double.parseDouble(request.getParameter("price"));
    Product newProduct = new Product(title, price);
    productDao.saveProduct(newProduct);
    response.sendRedirect("list");
  }

  public void deleteProduct(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    productDao.deleteProduct(id);
    response.sendRedirect("list");
  }

}
