function editBook(id) {
	window.location.assign("/books/update/" + id);
}

function deleteBook(id) {
	window.location.assign("/books/delete/" + id);
}

function viewBook(id) {
	window.location.assign("/books/" + id);
}

function goHome() {
	window.location.assign("/books");
}

function addBook() {
	window.location.assign("/books/add");
}
