from django.shortcuts import render
from .models import LandingPage
from django.views.generic.base import TemplateView

# Create your views here.
def index(request):
    obs_lst = LandingPage.objects.all()
    print("Primo messaggio da Landingpage:", obs_lst[0].message)

    context = {}
    context['message'] = obs_lst[0].message
    return render(request, 'landingpage/index.html', context=context)

class LandingpageView(TemplateView):
    template_name = 'landingpage/index.html'

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['message'] = LandingPage.objects.all()[1].message
        return context