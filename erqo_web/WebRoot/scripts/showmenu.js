function menuSwitch() {
	var menuObj = document.getElementById("menu");
	var switchObj = document.getElementById("switch");
	if (menuObj.style.display != "none") {
		menuObj.style.display = "none";
		switchObj.innerHTML = "&gt;";	
		switchObj.title = "显示菜单";
	} else {
		menuObj.style.display = "";
		switchObj.innerHTML = "&lt;";
		switchObj.title = "收起菜单";
	}

}
function IndexDeploy(ID){
	obj=document.getElementById("list_"+ID);	
	img=document.getElementById("icon_"+ID);
	if(obj.style.display=="none"){
		obj.style.display="block";
		img.innerHTML='-';
	}else{
		obj.style.display="none";
		img.innerHTML='+';
	}
	return false;
}

function Deploy(flag) {

	span = document.getElementById("itemlist").getElementsByTagName("span");
	ul = document.getElementById("itemlist").getElementsByTagName("ul");

	if (flag == 1) {
		for (i = 0; i < span.length; i++ ) {
			span[i].innerHTML='-';
		}
		for (i = 0; i < ul.length; i++ ) {
			ul[i].style.display="";
		}
	} else {
		for (i = 0; i < span.length; i++ ) {
			span[i].innerHTML='+';
		}
		for (i = 0; i < ul.length; i++ ) {
			ul[i].style.display="none";
		}
	}


}

