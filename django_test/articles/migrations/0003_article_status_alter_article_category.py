# Generated by Django 4.2.3 on 2023-08-01 08:19

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('articles', '0002_article_category_alter_article_img'),
    ]

    operations = [
        migrations.AddField(
            model_name='article',
            name='status',
            field=models.CharField(choices=[('DRAFT', 'Draft'), ('PUBLISHED', 'Published')], default='PUBLISHED', max_length=10),
        ),
        migrations.AlterField(
            model_name='article',
            name='category',
            field=models.CharField(choices=[('TC', 'Tecnologia'), ('SP', 'Sport'), ('SL', 'Salute'), ('TL', 'Tempo Libero')], default='TL', max_length=2),
        ),
    ]
