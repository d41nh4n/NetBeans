<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Accounts</title>
    </head>
    <body>
        <header><jsp:include page="../menu.jsp"/></header>
        <div class="mx-16">
            <h2 class="text-3xl font-bold dark:text-dark my-5 flex justify-center">List of Accounts</h2>
            <div class="overflow-x-auto shadow-md sm:rounded-lg mt-10">
                <table class="w-full text-base font-sans border-collapse">
                    <thead class="text-white text-left" style="background-color: #009879">
                        <tr>
                            <th scope="col" class="px-6 py-3">User Name</th>
                            <th scope="col" class="px-6 py-3">Role</th>
                            <th scope="col" class="px-6 py-3">Status</th>
                            <th scope="col" class="px-6 py-3">Email</th>
                            <th scope="col" class="px-6 py-3">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iterate over the list of accounts -->
                        <c:forEach items="${requestScope.accountList}" var="account">
                            <tr class="border-b">
                                <td class="px-6 py-4">${account.userName}</td>
                                <td class="px-6 py-4">${account.role}</td>
                                <td class="px-6 py-4">${account.status ? 'Active' : 'Inactive'}</td>
                                <td class="px-6 py-4">${account.email}</td>
                                <td class="px-6 py-4">
                                    <!-- Add an onclick event to trigger opening the modal -->
                                    <button type="button" onclick="openModal('${account.userName}')">Edit </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Modal -->
        <div id="editFormModal" class="modal hidden fixed inset-0 z-50 overflow-auto bg-gray-800 bg-opacity-50 flex justify-center items-center">
            <!-- Modal content -->
            <div class="bg-white w-1/3 rounded-lg p-8">
                <div class="flex justify-between">
                    <h2 class="text-2xl font-bold">Edit Account Status</h2>
                    <button id="closeModal" class="text-gray-600 hover:text-gray-900">&times;</button>
                </div>
                <form id="editForm" action="editaccount" method="post">
                    <div class="mt-4">
                        <!-- Add your form fields here -->
                        <label for="status">Status:</label>
                        <select name="status" id="status" class="mt-2 p-2 border border-gray-300 rounded-md">
                            <option value="true" <c:if test="${account.status}">selected</c:if>>Active</option>
                            <option value="false" <c:if test="${!account.status}">selected</c:if>>Inactive</option>
                        </select>
                        <input type="hidden" id="username" name="username">
                        <button type="submit" class="mt-4 px-4 py-2 bg-blue-500 text-white rounded-md">Save</button>
                    </div>
                </form>
            </div>
        </div>

        <!-- Include the JavaScript code at the end to ensure DOM elements are loaded -->
        <script>
            // JavaScript to handle opening and closing the modal
            const openModal = (userName) => {
                const editFormModal = document.getElementById('editFormModal');
                const userNameInput = document.getElementById('username');
                // Set the value of the hidden input field
                userNameInput.value = userName;
                // Show the modal
                editFormModal.classList.remove('hidden');
            };

            const closeModalButton = document.getElementById('closeModal');
            closeModalButton.addEventListener('click', () => {
                const editFormModal = document.getElementById('editFormModal');
                // Hide the modal
                editFormModal.classList.add('hidden');
            });
        </script>
    </body>
</html>
