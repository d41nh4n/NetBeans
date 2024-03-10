<%-- 
    Document   : menu
    Created on : Feb 21, 2024, 12:49:14 AM
    Author     : Dai Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <!-- TW Elements is free under AGPL, with commercial license required for specific uses. See more details: https://tw-elements.com/license/ and contact us for queries at tailwind@mdbootstrap.com --> 
    <!-- Main navigation container -->
    <header>
        <script src="https://cdn.tailwindcss.com"></script>
    </header>

    <nav
        class="relative flex w-full flex-nowrap items-center justify-between bg-neutral-800 py-2 text-neutral-500 shadow-lg hover:text-neutral-700 focus:text-neutral-700 lg:flex-wrap lg:justify-start lg:py-4"
        data-te-navbar-ref>
        <div class="flex w-full flex-wrap items-center justify-between px-3">
            <div class="mx-2">
                <a class="text-xl text-neutral-100" href="#">Logo</a>
            </div>
            <!-- Hamburger button for mobile view -->
            <button
                class="block border-0 bg-transparent px-2 text-neutral-300 hover:no-underline hover:shadow-none focus:no-underline focus:shadow-none focus:outline-none focus:ring-0 dark:text-neutral-200 lg:hidden"
                type="button"
                data-te-collapse-init
                data-te-target="#navbarSupportedContent10"
                aria-controls="navbarSupportedContent10"
                aria-expanded="false"
                aria-label="Toggle navigation">
                <!-- Hamburger icon -->
                <span class="[&>svg]:w-7">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                        fill="currentColor"
                        class="h-7 w-7">
                    <path
                        fill-rule="evenodd"
                        d="M3 6.75A.75.75 0 013.75 6h16.5a.75.75 0 010 1.5H3.75A.75.75 0 013 6.75zM3 12a.75.75 0 01.75-.75h16.5a.75.75 0 010 1.5H3.75A.75.75 0 013 12zm0 5.25a.75.75 0 01.75-.75h16.5a.75.75 0 010 1.5H3.75a.75.75 0 01-.75-.75z"
                        clip-rule="evenodd" />
                    </svg>
                </span>
            </button>

            <!-- Collapsible navbar container -->
            <div
                class="!visible mt-2 hidden flex-grow basis-[100%] items-center lg:mt-0 lg:!flex lg:basis-auto"
                id="navbarSupportedContent10"
                data-te-collapse-item>
                <!-- Left links -->
                <ul
                    class="list-style-none mr-auto flex flex-col pl-0 lg:mt-1 lg:flex-row"
                    data-te-navbar-nav-ref>
                    <!-- Home link -->
                    <li
                        class="my-4 pl-2 lg:my-0 lg:pl-2 lg:pr-1"
                        data-te-nav-item-ref>
                        <a
                            class="text-neutral-300 transition duration-200 hover:text-neutral-200 hover:ease-in-out focus:text-neutral-200 disabled:text-black/30 motion-reduce:transition-none lg:px-2 [&.active]:text-black/90 [&.active]:text-neutral-200"
                            aria-current="page"
                            href="listroom"
                            data-te-nav-link-ref
                            >Room</a
                        >
                    </li>
                    <!-- Features link -->
                    <li
                        class="mb-4 pl-2 lg:mb-0 lg:pl-0 lg:pr-1"
                        data-te-nav-item-ref>
                        <a
                            class="p-0 text-neutral-300 transition duration-200 hover:text-neutral-200 hover:ease-in-out focus:text-neutral-200 disabled:text-black/30 motion-reduce:transition-none lg:px-2 [&.active]:text-black/90 [&.active]:text-neutral-200"
                            href="listcustomer"
                            data-te-nav-link-ref
                            >Customer</a
                        >
                    </li>
                    <!-- Pricing link -->
                    <li
                        class="mb-4 pl-2 lg:mb-0 lg:pl-0 lg:pr-1"
                        data-te-nav-item-ref>
                        <a
                            class="p-0 text-neutral-300 transition duration-200 hover:text-neutral-200 hover:ease-in-out focus:text-neutral-200 disabled:text-black/30 motion-reduce:transition-none lg:px-2 [&.active]:text-black/90 [&.active]:text-neutral-200"
                            href="listbooking"
                            data-te-nav-link-ref
                            >Booking</a
                        >
                    </li>
                    <!-- About link -->
                    <li
                        class="mb-4 pl-2 lg:mb-0 lg:pl-0 lg:pr-1"
                        data-te-nav-item-ref>
                        <a
                            class="p-0 text-neutral-300 transition duration-200 hover:text-neutral-200 hover:ease-in-out focus:text-neutral-200 disabled:text-black/30 motion-reduce:transition-none lg:px-2 [&.active]:text-black/90 [&.active]:text-neutral-200"
                            href="choicehistory"
                            data-te-nav-link-ref
                            >History</a>
                    </li>
                    <c:if test="${sessionScope.manager.role eq 1}">
                        <li
                            class="mb-4 pl-2 lg:mb-0 lg:pl-0 lg:pr-1"
                            data-te-nav-item-ref>
                            <a
                                class="p-0 text-neutral-300 transition duration-200 hover:text-neutral-200 hover:ease-in-out focus:text-neutral-200 disabled:text-black/30 motion-reduce:transition-none lg:px-2 [&.active]:text-black/90 [&.active]:text-neutral-200"
                                href="listemployee"
                                data-te-nav-link-ref
                                >Employee</a>
                        </li>

                        <li
                            class="mb-4 pl-2 lg:mb-0 lg:pl-0 lg:pr-1"
                            data-te-nav-item-ref>
                            <a
                                class="p-0 text-neutral-300 transition duration-200 hover:text-neutral-200 hover:ease-in-out focus:text-neutral-200 disabled:text-black/30 motion-reduce:transition-none lg:px-2 [&.active]:text-black/90 [&.active]:text-neutral-200"
                                href="listaccount"
                                data-te-nav-link-ref
                                >Account</a>
                        </li>
                    </c:if>
                    <!-- Login - Logout -->
                    <c:if test="${ not empty sessionScope.manager}">
                        <li
                            class="mb-4 pl-2 lg:mb-0 lg:pl-0 lg:pr-1"
                            data-te-nav-item-ref>
                            <a
                                class="p-0 text-neutral-300 transition duration-200 hover:text-neutral-200 hover:ease-in-out focus:text-neutral-200 disabled:text-black/30 motion-reduce:transition-none lg:px-2 [&.active]:text-black/90 [&.active]:text-neutral-200"
                                href="logout"
                                data-te-nav-link-ref
                                >LogOut</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.manager}">
                        <li
                            class="mb-4 pl-2 lg:mb-0 lg:pl-0 lg:pr-1"
                            data-te-nav-item-ref>
                            Hello ${sessionScope.manager.userName}
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</html>

