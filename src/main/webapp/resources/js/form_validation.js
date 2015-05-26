function edit(url) {

	window.location.assign(url);
    return false;
}

function removeEmp(url) {

	if(confirm("Are you sure want to delete the Employee?")) {
		window.location.assign(url);
		return true;
	}
    return false;
}
