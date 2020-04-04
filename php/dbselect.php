<?php
//header('Content-type:applicaion/json');

$host="localhost";
$user="root";
$pass="";
$db_name="blood";

$connection = mysqli_connect($host,$user,$pass,$db_name);

if(mysqli_connect_errno())
{
die("connection field".mysqli_connect_error()."(".mysqli_connect_errno().")");
}
$query = "SELECT * FROM register";

$result = mysqli_query($connection,$query);

$rows=array();

while($row = mysqli_fetch_array($result))
{
	array_push($rows,array('Name'=>$row[0],'Age'=>$row[1],'Blood_Group'=>$row[2],'Mobile'=>$row[3],'Email'=>$row[4],'Address'=>$row[5],'City'=>$row[6]));

}

echo json_encode(array("result"=>$rows));



?>