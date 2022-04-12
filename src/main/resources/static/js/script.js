function editBook(id) {
	window.location.assign("/book/update/" + id);
}

function deleteBook(id) {
	window.location.assign("/book/delete/" + id);
}