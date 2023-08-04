from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User 
from .models import Profile

class RegistrationForm(UserCreationForm):

    first_name = forms.CharField(max_length=40, required=False, help_text='Optional.')
    last_name = forms.CharField(max_length=40, required=False, help_text='Optional.')
    birthday = forms.DateField(required=False, help_text='Optional. Format: YYYY-MM-DD.')
    email = forms.CharField(max_length=120, help_text='Required. Submit a valid email address.')
    
    # Permette di customizzare le informazioni della classe 
    class Meta: 
        model = User
        fields = ['username', 'first_name', 'last_name', 'birthday', 'email', 'password1', 'password2',]

class UserEditForm(forms.ModelForm):
    class Meta:
        model = User
        fields = ('username', 'email',)

class ProfileEditForm(forms.ModelForm):
    class Meta:
        model = Profile
        fields = ('birthday',)
