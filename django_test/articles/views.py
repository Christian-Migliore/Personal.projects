# from django.shortcuts import render
from django.views.generic.detail import DetailView
from django.views.generic.list import ListView

from .models import Article

# Create your views here.
class ArticleDetailView(DetailView):
    model = Article

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)

        return context
    
class ArticlesListView(ListView):
    model = Article
    paginate_by = 3
    
    # Filtri di selezione 
    def get_queryset(self):
        tag = self.kwargs.get('category_tag', None)
        queryset = Article.objects.filter(status='PUBLISHED')
        if tag:
            queryset = Article.objects.filter(status='PUBLISHED').filter(category__in=[tag])
        return queryset

    def get_context_data(self, **kwargs):
        # Creazione context landingpage
        context = super().get_context_data(**kwargs)
        
        # context['articles_list'] = articles

        return context