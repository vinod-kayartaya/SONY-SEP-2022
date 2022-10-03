def dirr(obj):
    return [at for at in dir(obj) if not at.startswith('_')]
