<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11835
  Date: 2018/9/9
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="//cdn.jsdelivr.net/sockjs/1.0.0/sockjs.min.js"></script>
<script src="<s:url value="/resources/stomp.js"/>"></script>
<script>
    var url='http://'+window.location.host+'/marcopolo';
    var socket=new SockJS(url);
    console.info(socket.url);
    var stomp=Stomp.over(socket);
    var payload=JSON.stringify({'message':'Marco!'});
    stomp.connect('guest','guest',function (frame) {
        stomp.send("/app/marco",{},payload);
        stomp.subscribe("/topic/marco",handleOneTime)
    });
        // websocket
    // socket.onopen=function () {
    //     console.log('opening');
    //     sayMarco();
    // };
    // socket.onmessage=function (ev) {
    //     console.log('receive message: '+ev.data);
    //     setTimeout(function () {
    //         sayMarco()
    //     },2000);
    // };
    // socket.onclose=function () {
    //     console.log('closing');
    // };
    // function sayMarco() {
    //     console.log("sending marco");
    //     socket.send("Marco!");
    // }
    function handleOneTime(message) {
        console.log('Received: ', message);
        sayMarco();
    }
    function handlePolo(message) {
        console.log('Received: ', message);
        if (JSON.parse(message.body).message === 'Polo!') {
            setTimeout(function(){sayMarco()}, 2000);
        }
    }
    function sayMarco() {
        console.log('Sending Marco!');
        stomp.send("/app/marco", {},
            JSON.stringify({ 'message': 'Marco!' }));
    }
</script>
<c:out value="${test.username}"/><br/>
    <c:out value="${test.username}"/><br/>
<a href="<s:url value="/register"/>"><button>注册</button></a>