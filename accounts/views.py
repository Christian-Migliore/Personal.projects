from django.shortcuts import redirect, render
from django.contrib.auth.decorators import login_required
from .forms import RegistrationForm, UserEditForm, ProfileEditForm
from django.contrib.auth import authenticate, login
from django.contrib import messages

# Create your views here.
@login_required
def profile(request):
    return render(request, 'accounts/profile.html')

def register(request):
    if request.method == 'POST':
        form = RegistrationForm(request.POST)
        if form.is_valid():
            user = form.save()
            user.refresh_from_db() # Aggiornamento user per salvataggio del profilo
            user.profile.birthday = form.cleaned_data.get('birthday')
            user.profile.save()
            raw_password = form.cleaned_data.get('password1')
            user = authenticate(username=user.username, password=raw_password)
            login(request, user)
            return redirect('accounts:profile')
    else:
        form = RegistrationForm()
    return render(request, 'registration/registration.html', {'form': form})

@login_required
def edit(request):
    if request.method == 'POST':
        user_form = UserEditForm(instance=request.user, data=request.POST)
        profile_form = ProfileEditForm(instance=request.user.profile, 
                                       data= request.POST)
        if user_form.is_valid() and profile_form.is_valid():
            user_form.save()
            profile_form.save()
            messages.success(request, 'Il tuo profilo è stato salvato correttamente.')
            return render(request, 'accounts/profile.html')
        else:
            messages.error(request, 'I dati inseriti non sono validi.', extra_tags='danger')
    else: 
        user_form = UserEditForm(instance= request.user)
        profile_form = ProfileEditForm(instance= request.user.profile)
    return render(request, 
                  'registration/edit.html', 
                  {'user_form': user_form, 
                   'profile_form': profile_form})