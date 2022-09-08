package servlet;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.ShopingDao;
import helpers.BuyingManager;
import helpers.HistoryManager;
import helpers.ProductsManager;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDao;
    private ShopingDao shopingDao;
    private BuyingManager buyingManager;
    private HistoryManager historyManager;
    private ProductsManager productsManager;

    public void init() {
        productDao = new ProductDao();
        shopingDao = new ShopingDao();
        buyingManager = new BuyingManager(shopingDao, productDao);
        historyManager = new HistoryManager(shopingDao, productDao);
        productsManager = new ProductsManager(productDao);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/new":
                    this.historyManager.showNewForm(request, response);
                    break;
                case "/insert":
                    this.productsManager.insertProduct(request, response);
                    break;
                case "/delete":
                    this.productsManager.deleteProduct(request, response);
                    break;
                case "/edit":
                    this.historyManager.showEditForm(request, response);
                    break;
                case "/update":
                    this.productsManager.updateProduct(request, response);
                    break;
                case "/buying":
                    this.buyingManager.buyingProducts(request, response);
                    break;
                case "/card":
                    this.historyManager.showBasketPage(request, response);
                    break;
                case "/purchase-history":
                    this.historyManager.showPurchaseHistory(request, response);
                    break;
                case "/list":
                    this.productsManager.listProducts(request, response);
                    break;
                default:
                    this.historyManager.showNewForm(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/buying":
                    // add selected product to session and redirect to selecting count
                    this.buyingManager.saveSelectedProduct(request);
                    this.productsManager.selectProductCount(request, response);
                    break;
                case "/buying-count":
                    this.historyManager.saveSelectedCountToSession(request);
                    this.historyManager.addToBasket(request);
                    this.historyManager.showBasketPage(request, response);
                    break;
                case "/purchase":
                    this.buyingManager.persistPurchase(request, response);
                    this.historyManager.showPurchaseHistory(request, response);
                    break;
                default:
                    doGet(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}