<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="components/header.jsp"%>

<div>


    <form class="calculator" name="calc" action="calculate" method="post">
        <input class="value" type="text" name="txt"  value="${result}">

        <span class="num clear" onclick="document.calc.txt.value =''">c</span>
        <span class="num" onclick="document.calc.txt.value +='/'">/</span>
        <span class="num" onclick="document.calc.txt.value +='*'">*</span>
        <span class="num" onclick="document.calc.txt.value +='7'">7</span>
        <span class="num" onclick="document.calc.txt.value +='8'">8</span>
        <span class="num" onclick="document.calc.txt.value +='9'">9</span>
        <span class="num" onclick="document.calc.txt.value +='-'">-</span>
        <span class="num" onclick="document.calc.txt.value +='4'">4</span>
        <span class="num" onclick="document.calc.txt.value +='5'">5</span>
        <span class="num" onclick="document.calc.txt.value +='6'">6</span>
        <span class="num plus" onclick="document.calc.txt.value +='+'">+</span>
        <span class="num" onclick="document.calc.txt.value +='1'">1</span>
        <span class="num" onclick="document.calc.txt.value +='2'">2</span>
        <span class="num" onclick="document.calc.txt.value +='3'">3</span>
        <span class="num" onclick="document.calc.txt.value +='0'">0</span>
        <span class="num" onclick="document.calc.txt.value +='00'">00</span>
        <span class="num" onclick="document.calc.txt.value +='.'">.</span>
        <button type="submit" class="num equal"><i>=</i></button>

<%--        <span class="num equal">--%>
<%--        </span>--%>
    </form>

</div>

<%@include file="components/footer.jsp"%>
