function config($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index");
    $stateProvider
        .state('index', {
            url: "/index",
            templateUrl: "views/pages/conference.html",
            data: { pageTitle: 'index' }
        })
        .state('pages.blank_page_1', {
            url: "/blank_page1",
            templateUrl: "views/pages/blank-page.html",
            data: { pageTitle: 'Sample blank page' }
        })
        .state('pages.blank_page_2', {
            url: "/blank_page2",
            templateUrl: "views/pages/blank-page.html",
            data: { pageTitle: 'Another Sample blank page' }
        })
}
angular
    .module('conference')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });