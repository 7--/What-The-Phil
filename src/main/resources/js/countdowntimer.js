//countdowntimer.js - https://stackoverflow.com/a/20618517/1308453
function CountDownTimer(duration, granularity) {
  this.duration = duration;
  this.granularity = granularity || 1000;
  this.tickFtns = [];
  this.running = false;
}

CountDownTimer.prototype.start = function() {
  if (this.running) {
    return;
  }
  this.running = true;
  var start = Date.now(),
    that = this,
    diff, obj;

  (function timer() {
    diff = that.duration - (((Date.now() - start) / 1000) | 0);

    if (diff > 0) {
      setTimeout(timer, that.granularity);
    } else {
      diff = 0;
      that.running = false;
    }

    obj = CountDownTimer.parse(diff);
    that.tickFtns.forEach(function(ftn) {
      ftn.call(this, obj.days, obj.hours, obj.minutes, obj.seconds);
    }, that);
  }());
};

CountDownTimer.prototype.onTick = function(ftn) {
  if (typeof ftn === 'function') {
    this.tickFtns.push(ftn);
  }
  return this;
};

CountDownTimer.prototype.expired = function() {
  return !this.running;
};

CountDownTimer.parse = function(seconds) {
  let days = seconds / 86400 | 0;
  let remainder = seconds % 86400;
  let hours = remainder / 3600 | 0;
  remainder = seconds % 3600;
  let minutes = remainder / 60 | 0;
  remainder = remainder % 60;
  seconds = remainder | 0;
  return {
    days,
    hours,
    minutes,
    seconds
  };
};


