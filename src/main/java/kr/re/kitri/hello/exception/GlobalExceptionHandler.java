package kr.re.kitri.hello.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DataAccessException.class)
    public String handleSQLInvalidException(DataAccessException se) {
        return "데이터베이스 접속에 문제가 있습니다." + se.getMessage();
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException ae) {
        return "0으로 나누는 에러가 발생" + ae.getMessage();
    }
    
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public String handleSQLSyntaxException() {
        return "Syntax 에러";
    }

    @ExceptionHandler(value = SQLException.class)
    public String handleSQLException(SQLException se) {
        return "SQL 예외 발생" + se.getMessage();
    }
    
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return "나머지 에러는 다 여기서 처리" + e.getMessage();
    }
}
