from buggylib import divide, greet

def test_divide_WILL_FAIL():
    # This will cause ZeroDivisionError
    result = divide(10, 0)
    assert result == 0

def test_greet():
    assert greet("Test") == "Hello, Test!"  # WRONG - actual returns "Hi Test"
