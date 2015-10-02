<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="SlottingApp">

    <head>
        <meta charset="utf-8" />

        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="resources/css/style.css" />
    </head>

    <body>

        <div class="jumbotron">
            <div class="container">
                <div class="col-xs-8">
                    <div ng-view></div>
                </div>
            </div>
        </div>
        <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="http://code.angularjs.org/1.2.20/angular.js"></script>
        <script src="http://code.angularjs.org/1.2.20/angular-route.js"></script>
        <script src="http://code.angularjs.org/1.2.13/angular-cookies.js"></script>
        <script src="resources/js/app.js"></script>
        <script src="resources/modules/home/SlotController.js"></script>
        <script src="resources/modules/home/SlotService.js"></script>
    </body>
</html>