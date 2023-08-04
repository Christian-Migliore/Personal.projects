"""
URL configuration for django_test project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.urls import path, reverse_lazy
from django.contrib.auth import views as auth_views
from . import views

app_name = 'accounts'

urlpatterns = [
    # Indirizzi pagine di servizio utente
    path('login/', auth_views.LoginView.as_view(), name='login'), # Login
    path('logout/', auth_views.LogoutView.as_view(), name='logout'), # Logout
    path('password_change/', auth_views.PasswordChangeView.as_view(success_url=reverse_lazy('accounts:password_change_done')), name='password_change'), # Cambio password
    path('password_change/done/', auth_views.PasswordChangeDoneView.as_view(), name='password_change_done'), # Cambio password completato
    path('password_reset/', auth_views.PasswordResetView.as_view(success_url=reverse_lazy('accounts:password_reset_done')), name='password_reset'), # Reset password
    path('password_reset/done/', auth_views.PasswordResetDoneView.as_view(), name='password_reset_done'), # Reset - iniziato
    path('reset/<uidb64>/<token>/', auth_views.PasswordResetConfirmView.as_view(success_url=reverse_lazy('accounts:password_reset_complete')), name='password_reset_confirm'), # Reset password - cambio password
    path('reset/done/', auth_views.PasswordResetCompleteView.as_view(), name='password_reset_complete'), # Reset - completato
    path('profile/', views.profile, name='profile'), # Profilo utente
    path('registration/', views.register, name='register'), # Registrazione utente
    path('edit/', views.edit, name='edit'), # Modifica profilo
]
