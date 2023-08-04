from django.shortcuts import render
from django.views.generic.base import TemplateView
from django.core.paginator import Paginator

from articles.models import Article

from .models import LandingPage


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
        # Creazione context landingpage
        context = super().get_context_data(**kwargs)

        # Creazione articoli e aggiunta a landingpage
        articles = Article.objects.filter(status='PUBLISHED')
        context['banner'] = articles[0]
        context['highlights'] = articles[1:3]
        articles_list = articles[3: ]
        context['articles_list'] = articles_list

        # Creazione paginatore e aggiunta a landingpage 
        paginator = Paginator(articles_list, 3)
        page_number = self.request.GET.get('page')
        page_obj = paginator.get_page(page_number)
        context['page_obj'] = page_obj

        context['categories'] = Article.CATEGORIES

        return context