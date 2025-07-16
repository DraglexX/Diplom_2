package client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.Credentials;
import model.Ingredients;
import model.User;
import static io.restassured.RestAssured.given;

public class BurgerServiceClient {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";
    public static final String POST_CREATE_USER = "/api/auth/register";
    public static final String POST_LOGIN_USER = "/api/auth/login";
    public static final String ACTIONS_WITH_USER = "/api/auth/user";
    public static final String ACTIONS_WITH_ORDER = "/api/orders";
    public static final String GET_LIST_INGREDIENTS = "/api/ingredients";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String TYPE_JSON = "application/json";
    public static final String HEADER_AUTHORIZATION = "authorization";

    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .body(user)
                .post(POST_CREATE_USER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Авторизация пользователя")
    public ValidatableResponse loginUser(Credentials credentials){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .body(credentials)
                .post(POST_LOGIN_USER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Изменение данных пользователя с авторизацией")
    public ValidatableResponse changeDataUser(Credentials credentials, String token){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .header(HEADER_AUTHORIZATION, token)
                .body(credentials)
                .patch(ACTIONS_WITH_USER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Изменение данных пользователя без авторизации")
    public ValidatableResponse changeDataUser(Credentials credentials){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .body(credentials)
                .patch(ACTIONS_WITH_USER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Создание заказа с авторизацией")
    public ValidatableResponse createOrder(Ingredients ingredients, String token){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .header(HEADER_AUTHORIZATION, token)
                .body(ingredients)
                .post(ACTIONS_WITH_ORDER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Создание заказа без авторизации")
    public ValidatableResponse createOrder(Ingredients ingredients){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .body(ingredients)
                .post(ACTIONS_WITH_ORDER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Получение заказа определенного пользователя с авторизацией в системе")
    public ValidatableResponse receivingOrdersGivenUser(String token){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .header(HEADER_AUTHORIZATION, token)
                .get(ACTIONS_WITH_ORDER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Получение заказа определенного пользователя без авторизации в системе")
    public ValidatableResponse receivingOrdersGivenUser(){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .get(ACTIONS_WITH_ORDER)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Получение списка ингредиентов")
    public ValidatableResponse receivingListIngredients(){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .get(GET_LIST_INGREDIENTS)
                .then()
                .log()
                .ifValidationFails();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String token){
        return given()
                .log()
                .ifValidationFails()
                .baseUri(BASE_URI)
                .header(HEADER_CONTENT_TYPE, TYPE_JSON)
                .header(HEADER_AUTHORIZATION, token)
                .delete(ACTIONS_WITH_USER)
                .then()
                .log()
                .ifValidationFails();
    }
}
