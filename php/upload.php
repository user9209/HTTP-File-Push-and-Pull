<?php

/*
  Only 100 files uploaded
  Only 10 MB files maximum
  Filenames by Server
  Auth per Secret
  "true", "false" oder "... Error ..."
*/

include_once('./data/.auth.upload.php');

if (!isset($secrets) || sizeof($secrets) === 0)
  die("no auth users!");

$html_form_file_id = 'userfile';

if(!isset($_GET['auth']) || !in_array($_GET['auth'],$secrets, true))
  die("no auth!");

if(!isset($_FILES[$html_form_file_id]))
 die("no file!");

// limit in bytes
if($_FILES[$html_form_file_id]['size'] > 10485760)
  die("File size too large!");

if($_FILES[$html_form_file_id]['size'] < 1)
  die("File size too small!");

$old_file_array = scandir ( "./data/", SCANDIR_SORT_DESCENDING);

$num = date ("Ymd-His");

if(sizeof($old_file_array) > 103)
  die("Number of uploads reached!");

$uploaddir = './data/';

$org_name = $_FILES[$html_form_file_id]['name'];
$org_name_file = basename($_FILES[$html_form_file_id]['name']);

$upload_name = $num;
$uploadfile = $uploaddir.$upload_name;

$tmp_file = $_FILES[$html_form_file_id]['tmp_name'];

if (move_uploaded_file($tmp_file, $uploadfile)) {
    echo "true";
} else {
    echo "false";
}
?>

