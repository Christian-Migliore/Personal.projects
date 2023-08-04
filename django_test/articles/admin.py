from django.contrib import admin
from .models import Article

# Register your models here.
@admin.register(Article)
class ArticleAdmin(admin.ModelAdmin):
    prepopulated_fields = {'slug': ('title',)}
    list_display = ('title', 'author', 'created', 'published', 'updated')
    list_filter = ('created', 'author')
    search_fields = ('title', 'body')
    ordering = ('created', 'published') 