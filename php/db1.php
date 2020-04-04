<?php
//header('Content-type:applicaion/json');

$host="localhost";
$user="root";
$pass="";
$db_name="sit";

$connection = mysqli_connect($host,$user,$pass,$db_name);

if(mysqli_connect_errno())
{
die("connection field".mysqli_connect_error()."(".mysqli_connect_errno().")");
}
$query = "SELECT * FROM student; ";

$result = mysqli_query($connection,$query);

$rows = array();

while($row = mysqli_fetch_array($result))
{
	array_push($rows,array('regno'=>$row[0],
		'name'=>$row[1]));

}

echo json_encode(array("result"=>$rows));



?>