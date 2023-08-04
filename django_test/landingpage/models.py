from django.db import models

# Create your models here.
class LandingPage(models.Model):
    message = models.CharField(max_length=255, blank=True)

    def __str__(self):
        return self.message