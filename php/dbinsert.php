<?php

$host="localhost";
$user="root";
$pass="";
$db_name="blood";

$name=$_GET['name'];
$age=$_GET['age'];
$blood=$_GET['blood'];
$phone=$_GET['phone'];
$email=$_GET['email'];
$address1=$_GET['address'];
$city1=$_GET['city'];


$connection=mysqli_connect($host,$user,$pass,$db_name);

$sql="INSERT INTO `register`(`Name`, `Age`, `Blood_Group`, `Mobile`, `Email`, `Address`, `City`) VALUES ('$name','$age','$blood','$phone','$email','$address1','$city1')";


$result=mysqli_query($connection,$sql);




?>